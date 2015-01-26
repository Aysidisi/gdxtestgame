
package com.aysidisi.gdxtestgame.android;

import android.os.Bundle;

import com.aysidisi.gdxtestgame.GdxTestGame;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class AndroidLauncher extends AndroidApplication
{
	@Override
	protected void onCreate(final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		this.initialize(new GdxTestGame(), config);
	}
}
