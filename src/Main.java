
// Model -> Классы, которые содержат логику и данные.
// View -> Классы, содержащие методы по работе с интерфейсами.
// Controller -> Класс, который связывает между собой Model и View.


import Controller.Controller;

public class Main {
    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();
        controller.execute();
    }
}
