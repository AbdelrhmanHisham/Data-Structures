#include <iostream>
#include <vector>
using namespace std;
#include <stdexcept>

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
    vector<int> indices;

        for (int i =0 ; i< nums.size() ; i++){
            for (int j = i+1; j < nums.size(); j++)
            {
                if((nums[i] + nums[j]) == target){
                    indices.push_back(i);
                    indices.push_back(j);
                    return indices;
                }
            }
            
        }
        throw invalid_argument("Target not found");  
        }
};

int main(){

    vector<int> nums;
    nums.push_back(0);
    nums.push_back(1);
    nums.push_back(2);
    nums.push_back(3);
    nums.push_back(4);
    Solution indics;
    indics.twoSum(nums ,2);
    vector<int> vec = indics.twoSum(nums,3);
    cout<<"Size of Vec : "<<vec.size()<<endl;
    for (int i=0 ; i < vec.size() ; i++){
        cout<<vec[i];
        cout<<endl;
    }
    return 0;
}