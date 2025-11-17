import java.util.List;

public class Sociopath {

	public int findTheSociopath (int groupSize, List<int []> likeList) {
    if (groupSize <= 0 || likeList == null) {
        return -1;
    }//check for bad inputs
        int[] liked = new int[groupSize+1];//which person is liked by how many people
        boolean[] likes = new boolean[groupSize+1];//if a person likes someone
        for(int[] pair : likeList) {
        int a = pair[0];//person a likes person b
        int b = pair[1];//person b is liked by person a
        if (pair == null || pair.length != 2) {
            return -1;
        }
        if (a<1 || a>groupSize || b<1 || b>groupSize) {
            return -1;
    }//check inputs
            likes[a] = true;//person a likes someone so cant be sociopath
            liked[b]++;//person b's liked count increases
        }
        int cantidate = -1;//default value
        for(int i=1; i<=groupSize; i++) {
            if(likes[i]==false && liked[i]==groupSize-1) {
                 if (cantidate != -1) {
                     return -1;//more than one candidate, meanign there are no sociopaths
                }
            cantidate = i;//found a cantidate
            }
        }
        return cantidate;
	}
    public static void main(String[] args) {
        Sociopath sociopath = new Sociopath();
        int groupSize = 3;
        List<int []> likeList = List.of(new int[]{1, 2});
        int result = sociopath.findTheSociopath(groupSize, likeList);
        if(result!=-1){result=result+1;//because there is no person 0
            System.out.println("The Sociopath is Person# " + result);}
        else{
            System.out.println("The Sociopath is Person# " + result);}
    }
}
