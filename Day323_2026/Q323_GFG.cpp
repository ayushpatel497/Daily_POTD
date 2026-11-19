class Solution {
    void merge(int low, int mid, int high, vector<int>&arr) {
		vector<int>temp1, temp2;
		for (int i = low; i <= mid; ++i)temp1.push_back(arr[i]);
		for (int i = mid + 1; i <= high; ++i)temp2.push_back(arr[i]);
		int i = 0, j = 0;
		int idx = low;
		int n = temp1.size(), m = temp2.size();
		while (i<n && j<m) {
			if (temp1[i]&1 && temp2[j]&1) {
				if (temp1[i] >= temp2[j])arr[idx++] = temp1[i++];
				else
					arr[idx++] = temp2[j++];
			}
			else if (temp1[i]&1) {
				arr[idx++] = temp1[i++];
			}
			else if (temp2[j]&1) {
				arr[idx++] = temp2[j++];
			}
			else {
				if (temp1[i] <= temp2[j])arr[idx++] = temp1[i++];
				else
					arr[idx++] = temp2[j++];
			}
		}
		while (i<n) {
			arr[idx++] = temp1[i++];
		}
		while (j<m) {
			arr[idx++] = temp2[j++];
		}
	}
	void mergeSort(int low, int high, vector<int>&arr) {
		if (low <high) {
			int mid = low + (high - low)/2;
			mergeSort(low, mid, arr);
			mergeSort(mid + 1, high, arr);
			merge(low, mid, high, arr);
		}
	}
  public:
    void sortIt(vector<int>& arr) {
        // Q. Sort in Specific Order
        // code here
        int n = arr.size();
		mergeSort(0, n - 1, arr);
    }
};