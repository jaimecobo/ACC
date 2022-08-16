package edu.acc.java;

import edu.acc.java.lotto.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LottoServletA
 */
@WebServlet("/LottoServletC")
public class LottoServletC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_LOTTO_BALLS = 6;
	private static final int DEFAULT_MAX_BALL_NUM = 54;
	private static final int DEFAULT_SIMULATION_YEARS = 1;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LottoServletC() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Lotto lotto = new Lotto();
		lotto.setOut(out);

		int num_lotto_balls = 0;
		int max_ball_num = 0;
		int simulation_years = 0;
		HttpSession session = request.getSession();

		String replay = request.getParameter("replay");

		if (replay.equals("yes")) {

			// they want a replay, so use previous run parameters if available
			System.out.println("Replay simulation...");
			if (session.getAttribute("num_lotto_balls") != null) {
				num_lotto_balls = (int) session.getAttribute("num_lotto_balls");
				max_ball_num = (int) session.getAttribute("max_ball_num");
				simulation_years = (int) session.getAttribute("simulation_years");
			} else {
				System.out.print("<p>No session parameters found for previous run");
			}
		}

		// new simulation so use new parameters and save in session for
		// replays
		if (num_lotto_balls == 0) { // not set yet
			
			try {
				num_lotto_balls = Integer.parseInt(request.getParameter("num_lotto_balls"));
				max_ball_num = Integer.parseInt(request.getParameter("max_ball_number"));
				simulation_years = Integer.parseInt(request.getParameter("years"));
				session.setAttribute("num_lotto_balls", num_lotto_balls);
				session.setAttribute("max_ball_num", max_ball_num);
				session.setAttribute("simulation_years", simulation_years);
				// should do some sanity checks here...
			} catch (Exception ex) {
				out.println("<p>Parameters not found...");
				num_lotto_balls = DEFAULT_LOTTO_BALLS;
				max_ball_num = DEFAULT_MAX_BALL_NUM;
				simulation_years = DEFAULT_SIMULATION_YEARS;
				System.out.print("<p> Using default parameters");
			}
		}

		// set up this simulation
		lotto.setNum_lotto_balls(num_lotto_balls);
		lotto.setMax_ball_num(max_ball_num);
		lotto.setSimulation_years(simulation_years);

		String summary = "<h3>The odds are 1 in " + lotto.calc_odds() + " using " + lotto.getNum_lotto_balls()
				+ " balls and " + lotto.getMax_ball_num() + " ball numbers</h3>";
		request.setAttribute("summary", summary);

		// run a simulation
		lotto.setSimulator(
				new LotteryDrawing(lotto.getNum_lotto_balls(), lotto.getMax_ball_num(), lotto.getSimulation_years()));
		lotto.getSimulator().run_simulation();
		request.setAttribute("results", lotto.getSimulator().get_results());
		request.setAttribute("simulation_years", simulation_years);

		this.getServletContext().getRequestDispatcher("/lotto_results.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}