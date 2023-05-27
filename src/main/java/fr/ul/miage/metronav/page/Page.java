package fr.ul.miage.metronav.page;

public abstract class Page {
    protected Page previousPage;

    public void setPreviousPage(Page previousPage) {
        this.previousPage = previousPage;
    }

    public abstract void display();

    public void goToPreviousPage() {
        if (previousPage != null) {
            previousPage.display();
        } else {
            System.out.println("Il n'y a pas de page précédente.");
        }
    }
}
