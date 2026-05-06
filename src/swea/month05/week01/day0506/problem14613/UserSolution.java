package swea.month05.week01.day0506.problem14613;


import java.util.Arrays;
import java.util.HashMap;

class UserSolution {
    private HashMap<String,int[]> map;


    public void init() {
        map = new HashMap<>();
    }

    public String arrToString(char mName[]){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mName.length; i++) {
            if (mName[i] == '\0') break;
            sb.append(mName[i]);
        }
        return sb.toString();
    }
    public void makeList(char mName[], int mLength, int mListValue[]) {
        String name = arrToString(mName);
        int[] arr = Arrays.copyOf(mListValue, mLength);
        map.put(name, arr);
    }

    public void copyList(char mDest[], char mSrc[], boolean mCopy) {
        String dstName = arrToString(mDest);
        String srcName = arrToString(mSrc);
        if(mCopy){
            int[] srcArr = map.get(srcName);
            int[]dstArr = Arrays.copyOf(srcArr,srcArr.length);
            map.put(dstName,dstArr);
        }
        else{
            map.put(dstName,map.get(srcName));
        }
    }

    public void updateElement(char mName[], int mIndex, int mValue) {
        String name = arrToString(mName);
        map.get(name)[mIndex] = mValue;
    }

    public int element(char mName[], int mIndex) {
        String name = arrToString(mName);
        return map.get(name)[mIndex];
    }
}