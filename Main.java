import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        Scanner sc = new Scanner(System.in);

        boolean run = true;
        int num = 0;
        ArrayList<String[]> list = new ArrayList<>();

        while (run) {
            System.out.print("명령) ");
            String opt = sc.nextLine();

            if (opt.equals("종료")) {
                run = false;

            } else if (opt.equals("등록")) {
                System.out.print("명언 : ");
                String content = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();
                num++;

                String[] wiseSaying = {String.valueOf(num), author, content};
                list.add(wiseSaying);

                System.out.println(num + "번 명언이 등록되었습니다.");

            } else if (opt.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for (int i = list.size() - 1; i >= 0; i--) {
                    String[] saying = list.get(i);
                    System.out.println(saying[0] + " / " + saying[1] + " / " + saying[2]);
                }

            } else if (opt.startsWith("삭제?id=")) {
                String id = opt.substring("삭제?id=".length());
                boolean found = false;

                for (int i = 0; i < list.size(); i++) {
                    String[] saying = list.get(i);
                    if (saying[0].equals(id)) {
                        list.remove(i);
                        found = true;
                        System.out.println(id + "번 명언이 삭제되었습니다.");
                        break;
                    }
                }

                if (!found) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                }

            } else if (opt.startsWith("수정?id=")) {
                String id = opt.substring("수정?id=".length());
                boolean found = false;

                for (int i = 0; i < list.size(); i++) {
                    String[] saying = list.get(i);
                    if (saying[0].equals(id)) {
                        found = true;

                        System.out.println("명언(기존) : " + saying[2]);
                        System.out.print("명언 : ");
                        String newContent = sc.nextLine();
                        System.out.println("작가(기존) : " + saying[1]);
                        System.out.print("작가 : ");
                        String newAuthor = sc.nextLine();

                        saying[2] = newContent;
                        saying[1] = newAuthor;
                        break;
                    }
                }

                if (!found) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                }
            }
        }
    }
}
