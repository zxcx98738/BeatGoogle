import java.util.ArrayList;

public class KeywordList {
	private ArrayList<Keyword>list;
	
	public KeywordList() {
		this.list=new ArrayList<>();
	}
	
	public void add (Keyword keyword) {
		this.list.add(keyword);
		System.out.println("Done");
	}
	
	public void  find(String s) {
		int maxVal=-1;
		int maxIndex=-1;
		
		for(int i=0;i<this.list.size();i++) {
			int lcs =findLCS(this.list.get(i).name,s);
			if(lcs>maxVal) {
				maxVal=lcs;
				maxIndex=i;
			}
			
		}
		System.out.println(this.list.get(maxIndex).toString());
		
	}
	
	private int findLCS(String x,String y) {
		int n =x.length();
		int m=y.length();
		int[][]lcs=new int [n+1][m+1];
		
		lcs[0][0]=0;
		for(int i=0;i<=n;i++) {
			lcs[i][0]=0;
		}
		for(int j=0;j<=m;j++) {
			lcs[0][j]=0;
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(x.charAt(i-1)==y.charAt(j-1))
					lcs[i][j]=lcs[i-1][j-1]+1;
				else
					lcs[i][j]=(lcs[i-1][j]>lcs[i][j-1]?lcs[i-1][j]:lcs[i][j-1]);
			}
		}
		return lcs[n][m];
	}
}
