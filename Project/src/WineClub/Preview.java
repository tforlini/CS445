package WineClub;

import java.util.Scanner;

public class Preview implements Display{

	public Preview() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void selection(WineClub club) {
		
		MonthlySelection selection = club.getSelection();
		int i = 0;
		while (i < selection.wines.size()) {
			System.out.println("****************************************");
			System.out.println("Wine n°" + selection.wines.get(i).getID());
			System.out.println("Name:" + selection.wines.get(i).getPrice()+ "$");
			System.out.println("Type:" + selection.wines.get(i).getWineVariety());
			System.out.println("Price:" + selection.wines.get(i).getWineType());
			System.out.println("Price:" + selection.wines.get(i).getLabelName());
			System.out.println("Price:" + selection.wines.get(i).getGrape());
			System.out.println("Price:" + selection.wines.get(i).getRegion());
			System.out.println("Price:" + selection.wines.get(i).getCountry());
			System.out.println("Price:" + selection.wines.get(i).getMaker());
			System.out.println("Price:" + selection.wines.get(i).getYear());
			System.out.println("Rating:" + selection.wines.get(i).getRating()+ "/10");
			System.out.println("****************************************");
			i++;
		}
		
	}

	@Override
	public void wine(WineClub club) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("What Wine do you want information about ?");
		MonthlySelection selection = club.getSelection();
		String id = input.nextLine();
		int number = Integer.parseInt(id);
		
		Wine wine = selection.getWines().get(number);
		System.out.println("****************************************");
		System.out.println("Wine n°" + wine.getID());
		System.out.println("Name:" + wine.getPrice()+ "$");
		System.out.println("Type:" + wine.getWineVariety());
		System.out.println("Price:" + wine.getWineType());
		System.out.println("Price:" + wine.getLabelName());
		System.out.println("Price:" + wine.getGrape());
		System.out.println("Price:" + wine.getRegion());
		System.out.println("Price:" + wine.getCountry());
		System.out.println("Price:" + wine.getMaker());
		System.out.println("Price:" + wine.getYear());
		System.out.println("Rating:" + wine.getRating()+ "/10");
		System.out.println("****************************************");
	}

	@Override
	public void shipments(WineClub club) {
		// TODO Auto-generated method stub
		
	}

}
