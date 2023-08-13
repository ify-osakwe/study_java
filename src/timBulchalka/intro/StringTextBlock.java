package timBulchalka.intro;

public class StringTextBlock {
    public static void main(String[] args) {
        String bulletIt = "Print a bulleted list:\n" +
                "\t\u2022 First Point\n" +
                "\t\u2022 Second Point";
        System.out.println(bulletIt);

        String textBlock = """
                Print a bulleted list:
                    \u2022 First Point
                    \u2022 Second Point""";
        System.out.println(textBlock);
    }
}
