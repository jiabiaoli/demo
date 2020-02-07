package com.example;

import com.github.difflib.DiffUtils;
import com.github.difflib.algorithm.DiffException;
import com.github.difflib.patch.AbstractDelta;
import com.github.difflib.patch.Chunk;
import com.github.difflib.patch.Patch;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author jiabiaoli
 */
public class Main {
    public static void main(String[] args) throws IOException, DiffException {
        File src = new File("/Users/jiabiaoli/Desktop/v0/DruidPooledPreparedStatement.java");
        File target = new File("/Users/jiabiaoli/Desktop/v1/DruidPooledPreparedStatement.java");
        List<String> original = IOUtils.readLines(new FileInputStream(src), "UTF-8");
        List<String> revised = IOUtils.readLines(new FileInputStream(target), "UTF-8");
        Patch<String> diff = DiffUtils.diff(original, revised);
        List<AbstractDelta<String>> deltas = diff.getDeltas();
        deltas.forEach(delta -> {
            switch (delta.getType()) {
                case INSERT:
                    Chunk<String> insert = delta.getTarget();
                    int position = insert.getPosition();
                    System.out.println("--------新增--------\n行号:" + (position + 1) + "内容: " + insert.getLines());
                    break;
                case CHANGE:
                    Chunk<String> source = delta.getSource();
                    Chunk<String> target1 = delta.getTarget();
                    System.out.println("--------修改--------\n旧数据-- 行号:" + (source.getPosition() + 1) + "内容: " + source.getLines() + "\n" + "新数据-- 行号: " + (target1.getPosition() + 1) + "内容: " + target1.getLines());
                    break;
                case DELETE:
                    Chunk<String> delete = delta.getSource();
                    System.out.println("--------删除--------\n行号:" + (delete.getPosition() + 1) + "内容: " + delete.getLines());
                    break;
                case EQUAL:
//                    System.out.println("无变化");
                    break;
            }

        });

    }
}
