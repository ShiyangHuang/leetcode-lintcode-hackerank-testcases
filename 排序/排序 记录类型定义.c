#define MAXSIZE 50        //˳�����󳤶� 
typedef int keytype;      //�Զ���ؼ�������Ϊ���� 
typedef int elemtype;      
typedef struct            //�����¼����
{    keytype key;         //����ؼ������� 
     elemtype otheritem;  //�����¼�е����������� 
}recdtype;                //��¼�ڵ����� 
recdtype r[MAXSIZE];      //�����¼������
