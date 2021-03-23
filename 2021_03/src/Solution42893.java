//https://programmers.co.kr/learn/courses/30/lessons/42893
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution42893 {
    static class Link {
        int index;
        int base;
        int out;
        double linked;

        public Link(int index, int base, int out, double linked) {
            this.index = index;
            this.base = base;
            this.out = out;
            this.linked = linked;
        }
    }

    public static String extractBody(String word) { // body 추출
        Pattern bodyPt = Pattern.compile("\\<body>(?s)(.*)\\</body>");
        Matcher bodyMat = bodyPt.matcher(word);
        String body = "";
        if(bodyMat.find()) {
            body = bodyMat.group(1);
        }
        return body;
    }
    public static int solution(String word, String[] pages) {
        int answer = 987654321;
        word = word.toLowerCase();
        HashMap<String, Link> map = new HashMap<>();
        String[] names = new String[pages.length];

        for(int i = 0; i < pages.length; i++) {
            // url 추출
            Pattern urlPt = Pattern.compile("<meta property=\"og:url\" content=\\\"(.+?)\\\""); // url extract
            Matcher urlMat = urlPt.matcher(pages[i]);
            String url = "";
            if(urlMat.find()) {
                url = urlMat.group(1);
            }

            // body 부분 추출
            String body = extractBody(pages[i]);
            // 외부 링크 수 count
            Pattern aPt = Pattern.compile("(.*)<a href=");
            Matcher aMat = aPt.matcher(body);
            int aCnt = 0;
            while(aMat.find()) {
                aCnt++;
            }
            // 검색어 등장 횟수
            body = body.toLowerCase();
            int srchCnt = 0;
            int index = 0;
            while(true) {
                index = body.indexOf(word, index+word.length()-1);
                if(index < 0) break;
                char prev = body.charAt(index-1);
                char post = body.charAt(index+word.length());
                if(!Character.isLetter(prev) && !Character.isLetter(post)) { // 양쪽 모두 글자가 아니어야함
                    srchCnt++;
                }
            }

            map.put(url, new Link(i, srchCnt, aCnt, 0.0));
            names[i] = url;
        }

        for(int i = 0; i < pages.length; i++) {
            String body = extractBody(pages[i]);
            // 링크 점수
            Pattern aPt = Pattern.compile("<a href=\\\"(.*?)\\\"");
            Matcher aMat = aPt.matcher(body);
            String aUrl = "";
            while(aMat.find()) {
                aUrl = aMat.group(1);
                Link origin = map.get(names[i]);
                if(map.get(aUrl) != null && origin.base != 0 && origin.out != 0) {
                    double link = (double) origin.base / (double)origin.out;
                    Link tmp = map.get(aUrl);
                    tmp.linked += link;
                    map.put(aUrl, tmp);
                }
            }
        }

        //큰 매칭 값 찾기
        Iterator<String> keys = map.keySet().iterator();
        double value = 0.0;

        while(keys.hasNext()) {
            String next = keys.next();
            double matching = map.get(next).base + map.get(next).linked;
            if(value <= matching) {
                value = matching;
                if(value == matching) answer = Math.min(answer, map.get(next).index);
                else answer = map.get(next).index;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        String words = "blind";
        String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
        System.out.println(solution(words, pages));
    }
}
