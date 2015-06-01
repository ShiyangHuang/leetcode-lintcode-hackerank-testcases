#define MAXSIZE 50        //顺序表最大长度 
typedef int keytype;      //自定义关键字类型为整数 
typedef int elemtype;      
typedef struct            //定义记录类型
{    keytype key;         //定义关键字类型 
     elemtype otheritem;  //定义记录中的其他项数据 
}recdtype;                //记录节点类型 
recdtype r[MAXSIZE];      //定义记录型数组
