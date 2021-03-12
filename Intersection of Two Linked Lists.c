/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode *getIntersectionNode(struct ListNode *headA, struct ListNode *headB) {
    struct ListNode *hA=headA;
    int a=0;
     struct ListNode *hB=headB;
    int b=0;
    while(hA!=NULL)
    {
        a++;
        hA=hA->next;
    }
   
    while(hB!=NULL)
    {
        b++;
        hB=hB->next;
    }
    hB=headB;
    hA=headA;    
    // printf("%d, %d",a,b);
    int c;
    if(a>=b){
        c=(a-b);
        while(c!=0){
            hA=hA->next;
            c--;
        }
    }
    else{
        c=(b-a);
        while(c!=0){
            hB=hB->next;
            c--;
        }
    }
    while(hA!=hB){
        hA=hA->next;
        hB=hB->next;
    }
    // printf("%d, %d",hA->val,hB->val);
    if(hA==NULL || hB==NULL) return NULL;
    return hA;
}
