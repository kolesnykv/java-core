package com.knubisoft.tasks.algorithm.pascaltriangle;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleImpl implements PascalsTriangle {

    @Override
    public List<BigInteger> calculateLineOfPascalsTriangle(int lineNumber) {

        List<BigInteger> currow = new ArrayList<>();
        currow.add(BigInteger.valueOf(1));

        if (lineNumber == 0) {
            return currow;
        }
        List<BigInteger> prev = calculateLineOfPascalsTriangle(lineNumber - 1);

        BigInteger curr = null;
        for (int i = 1; i < prev.size(); i++) {
            curr = prev.get(i - 1).add(prev.get(i));
            currow.add(curr);
        }
        currow.add(BigInteger.valueOf(1));
        return currow;
    }


}
