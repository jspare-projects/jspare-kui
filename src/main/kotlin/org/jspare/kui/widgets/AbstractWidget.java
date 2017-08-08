package org.jspare.kui.widgets;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import org.jetbrains.annotations.NotNull;
import org.jspare.kui.Renderable;

import java.util.UUID;

public class AbstractWidget implements Renderable {

    private String id;

    public AbstractWidget() {
        this.id = UUID.randomUUID().toString();
    }

    @NotNull
    @Override
    public String getId() {
        return id;
    }

    @NotNull
    @Override
    public String render() {
        return null;
    }

    @Override
    public void render(@NotNull Handler<AsyncResult<String>> ar) {

    }
}
