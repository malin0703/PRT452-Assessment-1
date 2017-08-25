package psn.learn.graphic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graphic {

    /**
     * 通过矩阵数据检查该矩阵代表的图是否是连通。
     * @param values
     * @return
     */
    public boolean checkGraphicConnect(int[][] values){
        if(values == null || values.length <1){
            System.out.println("input values is null; not graphic");
            return false;
        }

        this.printGraphic(values);

        int nodeSize = values.length;
        int[] tmp = new int[nodeSize];
        initSetZero(tmp);


        checkByDFS(values,0,tmp);

        List<String> sigleNodes = new ArrayList<String>();
        for(int i=0 ;i<values.length;i++){
            if(tmp[i] < 1){
                sigleNodes.add(String.valueOf(i+1));
            }
        }

        if(!sigleNodes.isEmpty()){
            System.out.println("No." + Arrays.toString(sigleNodes.toArray(new String[sigleNodes.size()])) +" Node is single; not graphic");
            return false;
        } else {
            System.out.println("all node is connect;");
            return true;
        }
    }

    /**
     * 初始化节点的连通性的值；默认所有节点的连通性都是0，表示不连通；
     * @param tmp
     */
    public void initSetZero(int[] tmp){
        for(int i=0;i<tmp.length;i++){
            tmp[i] = 0;
        }
    }

    /**
     * 递归，判断每个节点所联通的下个节点是否有联通节点；如果，那么nodeConnect对应的参数设置为1；
     * @param values
     * @param node
     * @param nodeConnet
     */
    private void checkByDFS(int[][] values , int node, int[] nodeConnet){
        nodeConnet[node] = 1;
        for(int i = 0; i<values.length; i++){
            if(values[node][i] > 0 && nodeConnet[i]<1){
                checkByDFS(values,i,nodeConnet);
            }
        }
        return;
    }

    /**
     * print graphic matrix;
     * @param values
     */
    private void printGraphic(int[][] values){
        for(int i=0;i<values.length;i++){
            String tmp ="";
            for(int j=0;j<values[i].length;j++){
                tmp = tmp + values[i][j]+" ";
            }
            System.out.println(tmp);
        }
    }
}
