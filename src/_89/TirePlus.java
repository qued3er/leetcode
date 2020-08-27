package _89;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/914:22
 */
/*支持正则表达式的前缀树
* 对.的支持：
* 当遇到一个.时，我们需要的是遍历当前节点的所有子树[不包括子树节点]，看有无与.之后的字符匹配的。
* 功能1：仅仅查有无，找到就返回
* 功能2：查所有匹配的，需要遍历所有，满足就记录。*/
//为什么不用hashtable？当数据较少时采用hash存储可以
    //1.hash冲突[需要用链表来处理]
    //2.重复存储相同的字符
    //当数据多了 用Tire树

public class TirePlus {
    TireNode head;
    /** Initialize your data structure here. */
    public TirePlus() {
        head=new TireNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] target = word.toCharArray();
        TireNode cur=head;
        for(int i =0;i<target.length;i++){
            int index=target[i]-'a';
            if (cur.child[index]==null){
                cur.child[index]=new TireNode();
                cur.child[index].val=target[i];
            }
            cur=cur.child[index];
        }
        cur.isEnd=true;
    }
    //实现.的正则匹配
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        char[] target = word.toCharArray();
        TireNode cur=head;
        for (int i =0;i<target.length;i++){
            //使用switch可扩展==》方便之后再添加别的正则符号
            switch (target[i]){
                //当前的字符为.需要去找当前节点的所有子树，并拿所有子树的子树去与之后的字符串匹配。
                //跳过下一个节点进行匹配
                //要能提前return
                case '.':{
                    for (int j=0;j<cur.child.length;j++){
                        if (cur.child[j]!=null) {
                            cur = cur.child[j];
                            //从这个cur开始匹配，想回外层for循环
                            boolean flag=dotEscape(target,i+2,cur);
                            //一个匹配则匹配
                            if (flag){
                                return true;
                            }
                        }
                    }
                    break;
                }
                //正常字符串的处理，类似于hash表去查找
                default:{
                    int index=target[i]-'a';
                    if(cur.child[index]==null){
                        return false;
                    }
                    cur=cur.child[index];
                }
            }
        }
        if (cur.isEnd){
            return true;
        }else {
            return false;
        }
    }
    //i为.之后，tree children为.之后开始匹配的域===>栈溢出
    private boolean dotEscape(char[] target, int i, TireNode tireNode) {
        for(int j=i;j<target.length;j++){
            switch (target[i]) {
                case '.':{
                    for (int idx=0;idx<tireNode.child.length;idx++) {
                        if (tireNode.child[idx]!=null) {
                            boolean flag = dotEscape(target, i++, tireNode);
                            if (flag){
                                return true;
                            }
                        }

                    }
                }
                default: {
                    int index = target[i] - 'a';
                    if (tireNode.child[index] == null) {
                        return false;
                    }
                    tireNode = tireNode.child[index];
                }
            }
        }
        if (tireNode.isEnd){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        TirePlus tirePlus=new TirePlus();
        tirePlus.addWord("addadd");
        //6个.栈溢出   .打头出错  addadd.出错 3个连续的.就会栈溢出
        System.out.println(tirePlus.search("a...dd"));
    }
}
