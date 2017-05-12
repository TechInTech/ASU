/**
 * Example of Singleton design pattern. This is a class that manages a draw
 * engine for a game.
 * 
 * @author Acuna
 */

//THIS WILL NOT COMPILE.
public class SingletonExample {
    public class DrawEngine {
        private DrawEngine instance;
        private Window window;

        private DrawEngine() {
            window = new Window();
        }

        public DrawEngine getInstance() {
            if(instance == null)
                instance = new DrawEngine();

            return instance;
        }

        public void drawLine(ICartesianPoint p1, ICartesianPoint p2) {
            //...
        }
    }
}