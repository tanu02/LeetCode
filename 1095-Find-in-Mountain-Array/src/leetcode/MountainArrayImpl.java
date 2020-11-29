package leetcode;
class MountainArrayImpl implements MountainArray {
	int[] arr;
	public MountainArrayImpl(int[] arr) {
		this.arr = arr; 
	}
	@Override
	public int get(int arg0) {
		return arr[arg0]; 
	}

	@Override
	public int length() {
		return arr.length; 
	}

}

interface MountainArray {
	public int get(int index);

	public int length();
}