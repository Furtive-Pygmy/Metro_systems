package metro_system;

import java.util.List;

public class SmartCardService {

    private final SmartCardDAO dao = new SmartCardDAO();

    public List<SmartCard> searchCards(String cardId, String name) {
        return dao.search(cardId, name);
    }

    public double getBalance(String cardId) {
        return dao.getBalance(cardId);
    }

    public double addBalance(String cardId, double amount) {
        return dao.addBalance(cardId, amount);
    }
}
