package com.dshood.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dshood.game.Flappy;

public class MenuState extends State {

    private Texture backGround;
    private Texture playButton;

    public MenuState(GameStateManager gsm) {

        super(gsm);

        camera.setToOrtho(false, Flappy.WIDTH / 2, Flappy.HEIGTH / 2);

        backGround = new Texture("backGround.png");
        playButton = new Texture("playbutton.png");
    }

    @Override
    protected void handle() {

        if (Gdx.input.justTouched()) {

            gsm.push(new PlayState(gsm));
        }

    }

    @Override
    public void update(float dt) {

        handle();

    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(camera.combined);

        sb.begin();

        sb.draw(backGround,0,0);
        sb.draw(playButton,camera.position.x - playButton.getWidth() / 2, camera.position.y);

        sb.end();

    }

    @Override
    public void dispose() {

        backGround.dispose();
        playButton.dispose();
    }
}
