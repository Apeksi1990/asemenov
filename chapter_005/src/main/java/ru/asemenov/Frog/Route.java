package ru.asemenov.Frog;
/**
 * Class Route решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public enum Route {
    /**
     * Left route.
     */
    LEFT {
        @Override
        public Point jump(Point point) {
            return new Point(point.getX() + 1, point.getY() + 2);
        }

        @Override
        public Route changeRoute() {
            return LEFTFORWARD;
        }
    },
    /**
     * Left forward route.
     */
    LEFTFORWARD {
        @Override
        public Point jump(Point point) {
            return new Point(point.getX() + 2, point.getY() + 1);
        }

        @Override
        public Route changeRoute() {
            return FORWARD;
        }
    },
    /**
     * Forward route.
     */
    FORWARD {
        @Override
        public Point jump(Point point) {
            return new Point(point.getX() + 3, point.getY());
        }

        @Override
        public Route changeRoute() {
            return RIGHTFORWARD;
        }
    },
    /**
     * Right forward route.
     */
    RIGHTFORWARD {
        @Override
        public Point jump(Point point) {
            return new Point(point.getX() + 2, point.getY() - 1);
        }

        @Override
        public Route changeRoute() {
            return RIGHT;
        }
    },
    /**
     * Right route.
     */
    RIGHT {
        @Override
        public Point jump(Point point) {
            return new Point(point.getX() + 1, point.getY() - 2);
        }

        @Override
        public Route changeRoute() {
            return LEFT;
        }
    };

    /**
     * Jump.
     * @param point this.
     * @return new Point.
     */
    public abstract Point jump(Point point);

    /**
     * Change route.
     * @return new Route.
     */
    public abstract Route changeRoute();
}
