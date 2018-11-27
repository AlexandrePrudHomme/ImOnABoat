import java.util.Random;

public class RatingGenerator {

	public static void main (String[] args) {

		int userID = 1;
		int day = 1;
		int month = 5;
		int restaurentID = 1;
		int commentID = 1;
		String[] s = new String[20];

		/*
		s[0] = "The chairs were very comfortable";
		s[1] = "The lamb was gloppy and sloppy";
		s[2] = "Restaurant was nice and all but needs windows so it doesn't make you feel like you're eating in a cave";
		s[3] = "The cheese pizza was so cheesey";
		s[4] = "This place is da bomb";
		s[5] = "Such exotic flavours. Such wow.";
		s[6] = "I like kebobs. They have it here.";
		s[7] = "This place is BAWLIN' yo";
		s[8] = "That chicken was so raw it was still running around the field";
		s[9] = "There weren't enough ice cubes in my drink";
		s[10] = "Good food but they ran out of salad at the all you can eat salad bar";
		s[11] = "The caesar salad was just so amazing";
		s[12] = "The bacon wasn't crispy enough";
		s[13] = "Dang flabit they burnt my rabbit!";
		s[14] = "Pho-tastic!";
		s[15] = "The chicken fingers didn't come with any dipping sauces.";
		s[16] = "Great ribs.";
		s[17] = "Scrumptious.";
		s[18] = "The crispy bacon was so crispy.";
		s[19] = "Everything is awesome.";
		*/
		s[0] = "The chairs were very comfortable";
		s[1] = "I got to meet the owner";
		s[2] = "Restaurant has no windows";
		s[3] = "They should add cheese even if cheese is not an ingredient";
		s[4] = "This place is da bomb";
		s[5] = "Such exotic flavours. Such wow.";
		s[6] = "I like food. They have it here.";
		s[7] = "This place is BAWLIN yo";
		s[8] = "There was chickens next to the patio";
		s[9] = "There werent enough ice cubes in my drink";
		s[10] = "They ran out of water";
		s[11] = "The cutlery was so amazing";
		s[12] = "More food please";
		s[13] = "Hint of smoke in the air";
		s[14] = "Fantastic!";
		s[15] = "Finger licking good";
		s[16] = "Great";
		s[17] = "Scrumptious";
		s[18] = "Limited parking";
		s[19] = "Everything is awesome";


		for (int i = 0; i < 96; i++) {

			if (userID == 16) {
				userID = 1;
			}
			if (day == 29) {
				day = 1;
				month++;
			}
			if (restaurentID == 13) {
				restaurentID = 1;
			}
			if (commentID == 20) {
				commentID = 1;
			}

			System.out.println("INSERT INTO RATING\n\tVALUES ("+userID+",'2017-"+month+"-"+day+"',"+n()+","+n()+","+n()+","+n()+",'"+s[commentID]+"',"+restaurentID+");");

			userID++;
			day++;
			restaurentID++;
			commentID++;
		}
	}

	public static int n() {

		Random r = new Random();
		int Low = 1; //inclusive
		int High = 11; //exclusive
		int Result = r.nextInt(High-Low) + Low;

		return Result;
	}
}