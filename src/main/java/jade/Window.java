package jade;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;

import static org.lwjgl.glfw.GLFW.*;

public class Window {
    private static Window window = null;
    private final int width;
    private final int height;
    private final String title;

    private Window() {
        this.width = 1920;
        this.height = 1080;
        this.title = "HJ2D";


    }

    public static Window get() {

        if (Window.window == null) {
            Window.window = new Window();
        }

        return Window.window;
    }

    public void run() {
        System.out.println("Hello LWJGL" + Version.getVersion() + "!");
        init();
        loop();

    }

    public void init() {
//set up an error callback
        GLFWErrorCallback.createPrint(System.err).set();

//Initialize glfw
        if (!glfwInit()) {


            throw new IllegalStateException("unable to initialize Glfw");
        }

//Configure Glfw
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE);
    }

    public void loop() {


    }
}
