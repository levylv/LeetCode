class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> results;
        map<int, int> m;
        for (int i = 0;i != nums.size(); i++){
            if (m.find(nums[i]) == m.end()){
                m[target - nums[i]] = i;
            }
            else{
                results.push_back(m[nums[i]] + 1);
                results.push_back(i + 1);
                break;
            }
        }
        return results;
    }
};
