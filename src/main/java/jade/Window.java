package jade;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window {
    private static Window window = null;
    private final int width;
    private final int height;
    private final String title;
    private long glfwWindow;

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

        //Create The jade.Window

        glfwWindow = glfwCreateWindow(this.width ,this.height,this.title,NULL,NULL);

        if(glfwWindow == NULL){
            throw  new IllegalStateException("Failed To Create the GLFW window");

        }
        //Make the OpenGL context current
        glfwMakeContextCurrent(glfwWindow);
        //Enable v-sync
        glfwSwapInterval(1);

        //This line is critical for LWJGL's interoperation with GLFW's
        //OpenGL context, or any context that is managed externally.
        //LWJGL detects the context that is current in the current thread,
        //creates the GLCapabilities instance and makes the OpenGL
        //bindings available for use.
        GL.createCapabilities();

    }


    public void loop() {
        while(!glfwWindowShouldClose(glfwWindow)){
            //Poll events
            glfwPollEvents();

            glClearColor(1.0f,0.0f,0.0f,1.0f);
            glClear(GL_COLOR_BUFFER_BIT);

            glfwSwapBuffers(glfwWindow);


        }
    }
}
