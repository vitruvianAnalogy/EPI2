public class BuildingsWithSunsetView{
	//If building in east is smaller or equal in height to building in west,
	//then building in east cannot get the sunset.

	//As per the question we have to iterate from east to west
	//That means i can't tell whether a building can view sunset until
	//i reach the west most building

	//Brute force way is to store the buildings from east to west in an array
	//and then iterate the array in reverse so that we know height of west
	//buildings before east buildings

	//Another way is every time we encounter a building we figure whether
	//if the "top of the stack" building is shorter or not.
	//If top of the stack is shorter then we pop the stack until
	// the building is taller than the current building
	//HOW IS BRUTE FORCE BETTER THAN THIS APPROACH
	//1. Because brute force always uses O(n) space
	//2. this approach in best case, when buildings are in order
	//of increasing height, only O(1) space is used.

	//this method will work with both addlast and addFirst
	//the thing to keep in mind is addLast will work with removeLast
	//and addFirst will work with removeFirst();
	public static Deque<BuildingWithHeight> returnBuildingsThatCanSeeSunset(Iterator<Integer> sequence){
		int buildingIndex = 0;
		Deque<BuildingWithHeight> buildingsWithSunset = new ArrayDeque<>();
		//assuming that the sequence is going from east to west
		while(sequence.hasNext()){
			Integer building = sequence.next();
			while(!buildingsWithSunset.isEmpty() 
				&& (Integer.compare(building, buildingsWithSunset.getLast().height) >= 0)){
				buildingsWithSunset.removeLast();
			}
			buildingsWithSunset.addLast(new BuildingWithHeight(buildingIndex++,building));
		}
	}
}

class BuildingWithHeight{
	Integer id;
	Integer height;
	public BuildingWithHeight(Integer id, Integer height){
		this.id = id;
		this.height = height;
	}
}