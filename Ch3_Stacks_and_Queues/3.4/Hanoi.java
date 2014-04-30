public class Hanoi{

	public static void main(String[] args){
		int diskAmount = 5;
		Tower[] threeTower = new Tower[3];
		for(int i=0;i<3;++i){
			threeTower[i] = new Tower();
		}

		for(int i=diskAmount;i>0;--i){
			threeTower[0].add(i);
		}
		System.out.print("disks in first Tower from top to bottom: ");
		threeTower[0].printTower();

		threeTower[0].batchMoveTo(diskAmount, threeTower[1], threeTower[2]); //move disks from the first tower to the third tower
		
		System.out.print("disks in third Tower from top to bottom: ");
		threeTower[2].printTower();
	}
}