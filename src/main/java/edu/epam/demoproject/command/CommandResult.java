package edu.epam.demoproject.command;

public class CommandResult {
    private final String page;
    private final boolean isRedirect;

    private CommandResult(String page, boolean isRedirect) {
        this.page = page;
        this.isRedirect = isRedirect;
    }

    public static CommandResult setRedirectPage(String page) {
        return new CommandResult(page, true);
    }

    public static CommandResult setForwardPage(String page) {
        return new CommandResult(page, false);
    }

    public String getPage() {
        return page;
    }

    public boolean isRedirect() {
        return isRedirect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandResult that = (CommandResult) o;
        return isRedirect == that.isRedirect &&
                page.equals(that.page);
    }

    @Override
    public int hashCode() {
        int result = page != null ? page.hashCode() : 0;
        result = 31 * result + (isRedirect ? 1 : 0);
        return result;
    }
}

