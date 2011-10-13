package clojure.lang;

public class WrappedException extends ClojureException {

public WrappedException(String msg, Throwable cause) {
	super(msg, cause);
}

public WrappedException(Throwable cause) {
	super(cause);
}

}
