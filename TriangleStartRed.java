   public void Strafe(Direction direction) {
        if (direction == Left) {
            move(-0.6, -0.54, -0.6, -0.54);
        } else if (direction == Right) {
            move(0.6, 0.6, 0.6, 0.6);
        }
    }

    public void Turn(Direction direction) {
        if (direction == Left) {
            move(0.4, -0.4, -0.4, 0.4);
        } else if (direction == Right) {
            move(-0.4, 0.4, 0.4, -0.4);
        }
    }
