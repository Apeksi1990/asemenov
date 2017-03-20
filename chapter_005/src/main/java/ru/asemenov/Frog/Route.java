package ru.asemenov.Frog;

public enum Route {
    LEFT {
        @Override
        public Point route(Point point) {
            return new Point(point.getX() + 1, point.getY() + 2);
        }

        @Override
        public Route changeRoute() {
            return LEFTFORWARD;
        }
    },
    LEFTFORWARD {
        @Override
        public Point route(Point point) {
            return new Point(point.getX() + 2, point.getY() + 1);
        }

        @Override
        public Route changeRoute() {
            return FORWARD;
        }
    },
    FORWARD {
        @Override
        public Point route(Point point) {
            return new Point(point.getX() + 3, point.getY());
        }

        @Override
        public Route changeRoute() {
            return RIGHTFORWARD;
        }
    },
    RIGHTFORWARD {
        @Override
        public Point route(Point point) {
            return new Point(point.getX() + 2, point.getY() - 1);
        }

        @Override
        public Route changeRoute() {
            return RIGHT;
        }
    },
    RIGHT {
        @Override
        public Point route(Point point) {
            return new Point(point.getX() + 1, point.getY() - 2);
        }

        @Override
        public Route changeRoute() {
            return LEFT;
        }
    };
    public abstract Point route(Point point);
    public abstract Route changeRoute();
}
