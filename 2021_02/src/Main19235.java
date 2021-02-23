import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main19235 {
    public static int blue[][], green[][], answer;

    public static void one(int x, int y) {
        // blue
        boolean flag = false;
        for (int i = 1; i < 6; i++) {
            if (blue[x][i] != 0) {
                flag = true;
                blue[x][i - 1] = 1;
                break;
            }
        }
        if (!flag) blue[x][5] = 1;

        //green
        flag = false;
        for (int i = 1; i < 6; i++) {
            if (green[i][y] != 0) {
                flag = true;
                green[i - 1][y] = 1;
                break;
            }
        }
        if (!flag) green[5][y] = 1;
    }

    public static void two(int x, int y) {
        // blue
        boolean flag = false;
        for (int i = 2; i < 6; i++) {
            if (blue[x][i] != 0) {
                flag = true;
                blue[x][i - 1] = 2;
                blue[x][i - 2] = 2;
                break;
            }
        }
        if (!flag) {
            blue[x][5] = 2;
            blue[x][4] = 2;
        }

        // green
        flag = false;
        for (int i = 1; i < 6; i++) {
            if (green[i][y] != 0 || green[i][y + 1] != 0) {
                green[i - 1][y] = 2;
                green[i - 1][y + 1] = 2;
                flag = true;
                break;
            }
        }
        if (!flag) {
            green[5][y] = 2;
            green[5][y + 1] = 2;
        }
    }

    public static void three(int x, int y) {
        //blue
        boolean flag = false;
        for (int i = 1; i < 6; i++) {
            if (blue[x][i] != 0 || blue[x + 1][i] != 0) {
                blue[x][i - 1] = 3;
                blue[x + 1][i - 1] = 3;
                flag = true;
                break;
            }
        }
        if (!flag) {
            blue[x][5] = 3;
            blue[x + 1][5] = 3;
        }

        // green
        flag = false;
        for (int i = 2; i < 6; i++) {
            if (green[i][y] != 0) {
                green[i - 1][y] = 3;
                green[i - 2][y] = 3;
                flag = true;
                break;
            }
        }
        if (!flag) {
            green[5][y] = 3;
            green[4][y] = 3;
        }
    }

    public static void dropBlue() {
        int blueCount = 0;
        // erase
        for(int i = 2; i < 6; i++) {
            int count = 0;
            for(int j = 0; j < 4; j++) {
                if(blue[j][i] != 0) count++;
            }
            if(count == 4) {
                blueCount++;
                for(int j = 0; j < 4; j++) {
                    blue[j][i] = 0;
                }
            }
        }
        if(blueCount > 0) {
            for(int j = 4; j >= 0; j--) {
                for(int i = 0; i < 4; i++) {
                    if(blue[i][j] == 1) {
                        int idx = 0;
                        for(int k = j+1; k < 6; k++) {
                            if(blue[i][k] == 0) {
                                idx = k;
                            } else break;
                        }
                        blue[i][j] = 0;
                        blue[i][idx] = 1;
                    } else if(blue[i][j] == 2) {
                        if(j-1 >= 0 && blue[i][j-1] == 2) {
                            int idx = 0;
                            for(int k = j+1; k < 6; k++) {
                                if(blue[i][k] == 0) {
                                    idx = k;
                                } else break;
                            }
                            blue[i][j] = 0;
                            blue[i][j-1] = 0;
                            blue[i][idx] = 2;
                            blue[i][idx-1] = 2;
                        } else {
                            int idx = 0;
                            for(int k = j+1; k < 6; k++) {
                                if(blue[i][k] == 0) {
                                    idx = k;
                                } else break;
                            }
                            blue[i][j] = 0;
                            blue[i][idx] = 1;
                        }
                    } else if(blue[i][j] == 3) {
                        int idx = 0;
                        if(i+1 < 4 && blue[i+1][j] == 3) {
                            for(int k = j+1; k < 6; k++) {
                                if(blue[i][k] == 0 && blue[i+1][k] == 0) {
                                    idx = k;
                                } else break;
                            }
                            blue[i][j] = 0;
                            blue[i+1][j] = 0;
                            blue[i][idx-1] = 3;
                            blue[i+1][idx-1] = 3;
                        } else if(idx == 0){
                            for(int k = j+1; k < 6; k++) {
                                if(blue[i][k] == 0) {
                                    idx = k;
                                } else break;
                            }
                            blue[i][j] = 0;
                            blue[i][idx] = 1;
                        }
                    }
                }
            }
        }
        answer += blueCount;
    }

    public static void dropGreen() {
        int greenCount = 0;
        for(int i = 0; i < 6; i++) {
            int count = 0;
            for(int j = 0; j <4; j++) {
                if(green[i][j] != 0) count++;
            }
            if(count == 4) {
                greenCount++;
                for(int j = 0; j < 4; j++) {
                    green[i][j] = 0;
                }
            }
        }

        if(greenCount > 0) {
            for(int j = 0; j < 4; j++) {
                for(int i = 5; i >= 0; i--) {
                    if(green[i][j] == 1) {
                        int idx = 0;
                        for(int k = i+1; k < 6; k++) {
                            if(green[k][j] == 1) {
                                idx = k;
                            } else break;
                        }
                        green[i][j] = 0;
                        green[idx][j] = 1;
                    }
                    else if(green[i][j] == 2) {
                        if(j+1 < 4 && green[i][j+1] == 2) {
                            int idx = 0;
                            for(int k = i+1; k < 6; k++) {
                                if(green[k][j] == 0 && green[k][j+1] == 0) {
                                    idx = k;
                                } else break;
                            }
                            green[i][j] = 0;
                            green[i][j+1] = 0;
                            green[idx][j] = 2;
                            green[idx][j+1] = 2;
                        } else {
                            int idx = 0;
                            for(int k = i+1; k < 6; k++) {
                                if(green[k][j] == 1) {
                                    idx = k;
                                } else break;
                            }
                            green[i][j] = 0;
                            green[idx][j] = 1;
                        }
                    } else if(green[i][j] == 3) {
                        if(i-1 >= 0 && green[i-1][j] == 3) {
                            int idx = 0;
                            for(int k = i+1; k < 6; k++) {
                                if(green[k][j] == 0) {
                                    idx = k;
                                } else break;
                            }
                            green[i][j] = 0;
                            green[i-1][j] = 0;
                            green[idx][j] = 3;
                            green[idx-1][j] = 3;
                        } else {
                            int idx = 0;
                            for(int k = i+1; k < 6; k++) {
                                if(green[k][j] == 1) {
                                    idx = k;
                                } else break;
                            }
                            green[i][j] = 0;
                            green[idx][j] = 1;
                        }
                    }
                }
            }
        }
        answer += greenCount;
    }

    public static void moveBlue() {
        int count = 0;
        for (int i = 0; i < 2; i++) {
            boolean flag = false;
            for (int j = 0; j < 4; j++) {
                if (blue[j][i] != 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) count++;
        }
        //delete
        for (int i = 5; i > 5 - count; i--) {
            for (int j = 0; j < 4; j++) {
                blue[j][i] = 0;
            }
        }
        if(count > 0) {
            for (int j = 0; j < 4; j++) {
                for (int i = 5 - count; i >= 0; i--) {
                    if (blue[j][i] != 0) {
                        blue[j][i + count] = blue[j][i];
                        blue[j][i] = 0;
                    }
                }
            }
        }
    }

    public static void moveGreen() {
        int count = 0;
        for (int i = 0; i < 2; i++) {
            boolean flag = false;
            for (int j = 0; j < 4; j++) {
                if (green[i][j] != 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) count++;
        }
        //delete
        for (int i = 5; i > 5 - count; i--) {
            for (int j = 0; j < 4; j++) {
                green[i][j] = 0;
            }
        }
        if(count > 0) {
            for (int j = 0; j < 4; j++) {
                for (int i = 5 - count; i >= 0; i--) {
                    if (green[i][j] != 0) {
                        green[i + count][j] = green[i][j];
                        green[i][j] = 0;
                    }
                }
            }
        }
    }

    public static int blockCount() {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                if (blue[i][j] != 0) count++;
            }
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (green[i][j] != 0) count++;
            }
        }
        return count;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        int test = Integer.parseInt(st.nextToken());
        blue = new int[4][6];
        green = new int[6][4];
        answer = 0;
        for (int ts = 1; ts <= test; ts++) {
            st = new StringTokenizer(bf.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            switch (t) {
                case 1:
                    one(x, y);
                    break;
                case 2:
                    two(x, y);
                    break;
                case 3:
                    three(x, y);
                    break;
            }
            dropBlue();
            dropGreen();
            moveBlue();
            moveGreen();
//            System.out.println("-------- " + t+ " " + x + " " + y);
//            for(int p[]: blue) System.out.println(Arrays.toString(p));
//            System.out.println();
//            for(int p[]: green) System.out.println(Arrays.toString(p));
//            System.out.println();
        }
        System.out.println(answer);
        System.out.println(blockCount());
    }
}
