public class Order {
    private String id;
    private double total;

    public Order(String id, double total) {
        this.id = id;
        this.total = total;
    }

    public void saveToDatabase() {
        System.out.println("Guardando pedido en la BD...");
    }

    public boolean validate() {
        return total > 0 && total <= 500;
    }
}



public class Task {
    private String description;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }

    // Representar tarea (correcto)
    public String getDescription() {
        return description;
    }

    // Calcular progreso (no debería estar aquí)
    public static double calculateProgress(Task[] tasks) {
        int completed = 0;
        for (Task t : tasks) {
            if (t.isCompleted()) {
                completed++;
            }
        }
        return (double) completed / tasks.length * 100;
    }

    // Enviar recordatorio (no debería estar aquí)
    public void sendReminder() {
        System.out.println("Recordatorio: debes completar la tarea " + description);
    }
}
