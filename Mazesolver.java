import java.util.*;

class Rat
{
    private static void solve(int i,int j,int a[][],int n,ArrayList<String> ans,String move,int vis[][],int di[],int dj[]){
        if(i==n-1 && j==n-1){
            ans.add(move);
            return;
        }
        String dir="DLRU";

        for(int idx=0;idx<4;i++){
            int nexti=i+di[idx];
            int nextj=j+dj[idx];
            if(nexti>=0 && nextj>=0 && nexti < n && nextj < n && vis[nexti][nextj]==0 && a[nexti][nextj]==1){
                vis[i][j]=1;
                solve(nexti,nextj,a,n,ans,move+dir.charAt(idx),vis,di,dj);
                vis[i][j]=0;
            }
        }
    }


    public static ArrayList<String> findpath(int m[][],int n){
        int vis[][]=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = 0;
            }
        }
        ArrayList<String> ans= new ArrayList<>();
        int di[]={+1,0,0,-1};
        int dj[]={0,-1,+1,0};

        if(m[0][0]==1) solve(0,0,m,n,ans,"",vis,di,dj);
        return ans;
    }
}

class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }
        Rat obj = new Rat();
        ArrayList < String > res = obj.findpath(a, n);
        if (res.size() > 0) {
            for (int i = 0; i < res.size(); i++)
            System.out.print(res.get(i) + " ");
            System.out.println();
        }
        else {
            System.out.println(-1);
        }
  }
}



