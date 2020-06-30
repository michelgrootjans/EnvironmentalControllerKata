package codingdojo;

import org.approvaltests.reporters.ClipboardReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

import static org.approvaltests.combinations.CombinationApprovals.verifyAllCombinations;

public class Approvals {
    @Test
    @UseReporter(ClipboardReporter.class)
    void approvals() {
        verifyAllCombinations(
                this::applyController,
                new Integer[]{5, 6, 15, 16, 24, 25, 29, 30}
                );
    }

    private Hardware applyController(int temperature) {
        HardwareStub hw = new HardwareStub();
        EnvironmentController controller = new EnvironmentController(hw);
        hw.setTemp(temperature);
        controller.tic();
        return hw;
    }

}
