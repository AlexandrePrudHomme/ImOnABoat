import java.util.Random;

public class RatingItemGenerator {

	public static void main (String[] args) {

		int userID = 1;
		int day = 1;
		int month = 5;
		int restaurentID = 1;
		int r1 = 1;
		int r2 = 1;
		int r3 = 1;
		int r4 = 1;
		int r5 = 1;
		int r6 = 1;
		int r7 = 1;
		int r8 = 1;
		int r9 = 1;
		int r10 = 1;
		int r11 = 1;
		int r12 = 1;

		int[] r1a = new int[]{2,17,18,19,20,21};
		int[] r2a = new int[]{1,37,38,39};
		int[] r3a = new int[]{4,14,15,27};
		int[] r4a = new int[]{12,13,26};
		int[] r5a = new int[]{5,22,23,24,25};
		int[] r6a = new int[]{29,30,36,40};
		int[] r7a = new int[]{31,32,33,34,45};
		int[] r8a = new int[]{3,8,10,11,16};
		int[] r9a = new int[]{28,41};
		int[] r10a = new int[]{9,42,43};
		int[] r11a = new int[]{44,45};
		int[] r12a = new int[]{6,7};

		int commentID = 1;
		String[] s = new String[20];
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
			if (commentID == 20) {
				commentID = 1;
			}
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
			
				if (r1 == 7) {
					r1 = 1;
				}
				if (r2 == 5) {
					r2 = 1;
				}
				if (r3 == 5) {
					r3 = 1;
				}
				if (r4 == 4) {
					r4 = 1;
				}
				if (r5 == 6) {
					r5 = 1;
				}
				if (r6 == 5) {
					r6 = 1;
				}
				if (r7 == 6) {
					r7 = 1;
				}
				if (r8 == 6) {
					r8 = 1;
				}
				if (r9 == 3) {
					r9 = 1;
				}
				if (r10 == 4) {
					r10 = 1;
				}
				if (r11 == 3) {
					r11 = 1;
				}
				if (r12 == 3) {
					r12 = 1;
				}

			if (restaurentID == 1){

				print(r1a[r1-1], userID, month, day, s[commentID]);
				r1++;
			}
			if (restaurentID == 2){

				print(r2a[r2-1], userID, month, day, s[commentID]);
				r2++;
}
			if (restaurentID == 3){
				
				print(r3a[r3-1], userID, month, day, s[commentID]);
				r3++;
}
			if (restaurentID == 4){
				
				print(r4a[r4-1], userID, month, day, s[commentID]);
				r4++;
}
			if (restaurentID == 5){
				
				print(r5a[r5-1], userID, month, day, s[commentID]);
				r5++;
}
			if (restaurentID == 6){
				
				print(r6a[r6-1], userID, month, day, s[commentID]);
				r6++;
}
			if (restaurentID == 7){
				
				print(r7a[r7-1], userID, month, day, s[commentID]);
				r7++;
}
			if (restaurentID == 8){
				
				print(r8a[r8-1], userID, month, day, s[commentID]);
				r8++;
}
			if (restaurentID == 9){
				
				print(r9a[r9-1], userID, month, day, s[commentID]);
				r9++;
}
			if (restaurentID == 10){
				
				print(r10a[r10-1], userID, month, day, s[commentID]);
				r10++;
}
			if (restaurentID == 11){
				
				print(r11a[r11-1], userID, month, day, s[commentID]);
				r11++;
}
			if (restaurentID == 12){
				
				print(r12a[r12-1], userID, month, day, s[commentID]);
				r12++;
			}

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

	public static void print(int n, int userID, int month, int day, String s){
		System.out.println("INSERT INTO RATINGITEM\n\tVALUES ("+userID+",'2017-"+month+"-"+day+"',"+n+","+n()+",'"+s+"');");
	}
}