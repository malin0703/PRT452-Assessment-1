package psn.learn.graphic.test;

import org.junit.Test;
import psn.learn.graphic.Graphic;

import java.util.Random;

/**
 * 测试用例说明；
 * 1. 使用图的关联矩阵；如果两个点之间有连接，就用1表示，如果不通，则用0表示；
 * 2. 由于只是测试无向联通图，所以关联矩阵是个对称矩阵；
 */
public class GraphicTest {

    @Test
    public void testCheckGraphicConnect(){
        int[][] values = this.initGraphicMatrix(5);
        Graphic grp = new Graphic();

        grp.checkGraphicConnect(values);

    }

    @Test
    public void testCheckGraphicConnctByFixedMatrix(){
        Graphic grp = new Graphic();
        grp.checkGraphicConnect(this.initFixGraphicmatrix());
    }

    private int[][] initFixGraphicmatrix(){
        int[][] result = new int[5][];
        for(int i =0 ;i < 5 ; i++){
            result[i] = new int[5];
        }

        /**
         *    a b c d e
         * a  0 1 0 1 0
         * b  1 0 1 0 1
         * c  0 1 0 1 0
         * d  1 0 1 0 1
         * e  0 1 0 1 0
         */
        result[0][0] = 0;
        result[0][1] = 1;
        result[0][2] = 0;
        result[0][3] = 1;
        result[0][4] = 0;

        result[1][0] = 1;
        result[1][1] = 0;
        result[1][2] = 1;
        result[1][3] = 0;
        result[1][4] = 1;

        result[2][0] = 0;
        result[2][1] = 1;
        result[2][2] = 0;
        result[2][3] = 1;
        result[2][4] = 0;

        result[3][0] = 1;
        result[3][1] = 0;
        result[3][2] = 1;
        result[3][3] = 0;
        result[3][4] = 1;

        result[4][0] = 0;
        result[4][1] = 1;
        result[4][2] = 0;
        result[4][3] = 1;
        result[4][4] = 0;

        return result;
    }

    /**
     * 初始化 nodeCnt 节点数的图形矩阵；
     * @param nodeCnt
     * @return
     */
    private int[][] initGraphicMatrix( int nodeCnt){

        int[][] result = new int[nodeCnt][];

        for(int i =0 ;i<nodeCnt ;i++){
            result[i] = new int[nodeCnt];
            for(int j = i; j<nodeCnt ; j++){
                if(j == i){
                    result[i][j] = 0; // 自己的节点设置为0；
                } else {
                    //对称矩阵；
                    result[j] = new int[nodeCnt];
                    int s = this.randomValue();
                    result[i][j] = s;
                    result[j][i] = s;
                }
            }
        }

        return result;
    }

    /**
     * 随机值
     * @return
     */
    private int randomValue(){
        Random random = new Random();
        return random.nextInt(2);
    }

}
