class Solution
{
    public:
        ListNode* addTwoNumbers(ListNode* l1, ListNode* l2)
        {
            ListNode *result, *p;
            result = new ListNode(-1);
            p = result;
            int flag = 0, sum;
            while(l1 != NULL || l2 != NULL || flag == 1)
            {
                if (l1 == NULL)
                {
                    l1 = new ListNode(0);
                }
                if (l2 == NULL)
                {
                    l2 = new ListNode(0);
                }
                sum =l1->val + l2->val + flag;
                if (sum >= 10)
                {
                    sum = sum % 10;
                    flag = 1;
                } 
                else
                {
                    flag = 0;
                }
                l1 = l1->next;
                l2 = l2->next;
                p->next = new ListNode(sum);
                p = p->next;
            }
            p = result->next;
            return p;
}
