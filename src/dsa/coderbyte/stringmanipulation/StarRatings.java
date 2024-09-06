package dsa.coderbyte.stringmanipulation;

/****************************************************************
 *             CODERBYTE STAR RATING CHALLENGE                  *
 *                                                              *
 * Problem Statement                                            *
 * Have the function StarRating(str) take the str parameter     *
 * being passed which will be an average rating between         *
 * 0.00 and 5.00, and convert this rating into a list of 5 image*
 * names to be displayed in a user interface to represent the   *
 * rating as a list of stars and half stars. Ratings should be  *
 * rounded to the nearest half. There are 3 image file names    *
 * available: "full.jpg", "half.jpg", "empty.jpg".              *
 * The output will be the name of the 5 images                  *
 * (without the extension), from left to right, separated by    *
 * spaces.                                                      *
 *                                                              *
 * Examples                                                     *
 * Input 1: "0.38"                                              *
 * Output 1: half empty empty empty empty                       *
 *                                                              *
 * Input 2: "4.5"                                               *
 * Output 2: full full full full half                           *
 *                                                              *
 * Solution Efficiency                                          *
 * The user scored higher than 77.9% of users who solved this   *
 * challenge.                                                   *
 *                                                              *
 ***************************************************************/
public class StarRatings {
    public static void main(String[] args) {

        System.out.println(starRating("0.38")); // half empty empty empty empty
        System.out.println(starRating("4.5"));  // full full full full half
        System.out.println(starRating("3.75")); // full full full half empty
        System.out.println(starRating("5.0"));  // full full full full full
        System.out.println(starRating("2.25")); // full full half empty empty
        System.out.println(starRating("2.7")); // Should print: full full half empty empty

    }

    public static String starRating(String str) {
        double rating = Double.parseDouble(str);
        rating = Math.round(rating * 2) / 2.0; // Round the rating to the nearest half
        StringBuilder result = new StringBuilder();

        // Convert the rating to stars
        for (int i = 1; i <= 5; i++) {
            if (rating >= 1.0) {
                result.append("full ");
                rating -= 1.0;
            } else if (rating >= 0.5) {
                result.append("half ");
                rating -= 0.5;
            } else {
                result.append("empty ");
            }
        }
        return result.toString().trim();
    }
}
