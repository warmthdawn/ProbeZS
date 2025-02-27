package youyihj.probezs.tree;

import youyihj.probezs.util.IndentStringBuilder;

/**
 * @author youyihj
 */
public class ZenPropertyNode implements IZenDumpable {
    private final LazyZenClassNode type;
    private final String name;

    private boolean hasGetter;
    private boolean hasSetter;

    private boolean isStatic;

    public ZenPropertyNode(LazyZenClassNode type, String name) {
        this.type = type;
        this.name = name;
    }

    public boolean isHasGetter() {
        return hasGetter;
    }

    public void setHasGetter(boolean hasGetter) {
        this.hasGetter = hasGetter;
    }

    public boolean isHasSetter() {
        return hasSetter;
    }

    public void setHasSetter(boolean hasSetter) {
        this.hasSetter = hasSetter;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public void setStatic(boolean aStatic) {
        isStatic = aStatic;
    }

    @Override
    public void toZenScript(IndentStringBuilder sb) {
        if (type.isExisted()) {
            String declareKeyword = isStatic ? "static" : isHasSetter() ? "var" : "val";
            sb.append(declareKeyword);
            sb.append(" ").append(name).append(" as ").append(type.get().getName()).append(";");
        }
    }
}
