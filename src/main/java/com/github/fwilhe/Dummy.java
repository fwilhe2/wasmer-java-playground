package com.github.fwilhe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.wasmer.*;

public class Dummy {
    public static void main(String[] args) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get("simple.wasm"));
        Instance instance = new Instance(bytes);

        Integer result = (Integer) instance.exports.getFunction("sum").apply(1, 2)[0];

        System.out.println(result.toString());

        assert result == 3;

        instance.close();
    }
}