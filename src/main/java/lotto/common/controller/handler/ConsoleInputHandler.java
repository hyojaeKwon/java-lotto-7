package lotto.common.controller.handler;

import java.util.List;
import java.util.function.Function;
import lotto.common.controller.parser.InputParser;
import lotto.common.controller.provider.InputProvider;

public class ConsoleInputHandler {

    private final InputProvider inputProvider;

    public ConsoleInputHandler(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    public long inputMoney() {
        return inputWithValidationAndParse(InputParser::parseLong);
    }

    public List<Integer> inputWinningLotto() {
        return inputWithValidationAndParse(InputParser::parseIntegerList);
    }

    public int inputBonusNumber() {
        return inputWithValidationAndParse(InputParser::parseInt);
    }

    public <T> T inputWithValidationAndParse(Function<String, T> parser) {
        String input = inputProvider.readLine();
        checkInputIsNull(input);
        return parser.apply(input);
    }

    private void checkInputIsNull(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 null 이거나 공백이 될 수 없습니다.");
        }
    }
}
