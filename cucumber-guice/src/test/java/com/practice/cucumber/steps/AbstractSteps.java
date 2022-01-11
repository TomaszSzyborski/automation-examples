package com.practice.cucumber.steps;

import com.practice.cucumber.context.World;
import com.google.inject.Inject;

public abstract class AbstractSteps{

    @Inject
    protected World world;

}

