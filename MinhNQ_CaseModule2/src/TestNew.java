import java.util.ArrayList;
import java.util.Scanner;

public class TestNew {

    static Scanner sc = new Scanner(System.in);

    static void menu() {
        System.out.println("1. Insert news");
        System.out.println("2. View list");
        System.out.println("3. Average rate");
        System.out.println("4. Exit");
    }

    static void inputNews(int id, News news) {
        int[] rate = new int[3];

        //"Nhập ID:"
        news.setId(id);

        System.out.println("Nhập title: ");
        String title = sc.nextLine();
        news.setTitle(title);
        System.out.println();

        System.out.println("Nhập publish date: ");
        String publishDate = sc.nextLine();
        news.setPublishDate(publishDate);
        System.out.println();

        System.out.println("Nhập author: ");
        String author = sc.nextLine();
        news.setAuthor(author);
        System.out.println();

        System.out.println("Nhập content: ");
        String content = sc.nextLine();
        news.setContent(content);
        System.out.println();

        System.out.println("Nhập đánh giá: ");
        for (int i = 0; i < 3; i++) {
            do {
                System.out.format("Đánh giá %d: ",i+1);
                rate[i] = Integer.parseInt(sc.nextLine());
                if (rate[i] < 1 || rate[i] > 5) {
                    System.out.println("Đánh giá là số nguyên từ 1 đến 5!");
                } else break;
            } while (true);
        }
        news.setRatelist(rate);
        System.out.println();
    }

    public static void main(String[] args) {
        String option;

        ArrayList<News> NewsList = new ArrayList<>();
        int id = 0;
        menu();
        while (true) {
            while (true) {
                try {
                    System.out.print("Nhập lựa chọn: ");
                    option = sc.nextLine();
                    System.out.println();
                    break;
                } catch (Exception exception) {
                    System.out.println("Hãy nhập 1 số nguyên trong menu");
                }
            }
            switch (option) {
                case "1":
                    id++;
                    News news = new News();
                    inputNews(id, news);
                    NewsList.add(news);
                    System.out.println("Đã thêm tin có id " + id + " vào danh sách");
                    break;
                case "2":
                    System.out.println("Danh sách tin:");
                    for (News newS:NewsList) {
                        newS.display();
                    }
                    break;
                case "3":
                    System.out.println("Danh sách tin sau khi tính trung bình rate: ");
                    for (News newS:NewsList) {
                        newS.calculate();
                        newS.display();
                    }
                    break;
                case "4":
                    return;
            }
        }
    }
}
