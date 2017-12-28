package tradingservices.trading;

import java.util.List;

public class Markets {

    private String id;
    private String name;
    private String type;
    private boolean closed;
    private boolean suspended;
    private List<Selections> selectionsList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    public List<Selections> getSelectionsList() {
        return selectionsList;
    }

    public void setSelectionsList(List<Selections> selectionsList) {
        this.selectionsList = selectionsList;
    }
}
