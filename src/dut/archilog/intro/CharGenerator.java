package dut.archilog.intro;

import java.util.List;

public interface CharGenerator {
    List<Character> generate(Memory<? extends Cell> memory);
}