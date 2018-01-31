package utility.initializer;

/**
 *
 * @author Jordan
 */
public interface Initializer {
    void initGridBagConstraints();
    void initJCompModelLoaders();
    void initRenderers();
    void initModels();
    void initViewComponents();
    void initControllers();
    void initDaoImpl();
}
