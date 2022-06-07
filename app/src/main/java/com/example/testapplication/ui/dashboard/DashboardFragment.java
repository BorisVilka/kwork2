package com.example.testapplication.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.example.testapplication.Question;
import com.example.testapplication.R;
import com.example.testapplication.TestListAdapter;
import com.example.testapplication.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private TestListAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        adapter = new TestListAdapter((pos)->{
            Bundle args = new Bundle();
            args.putInt("pos",pos);
            NavController controller = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);
            controller.navigate(R.id.navigation_test,args);
        });
        binding.list.setAdapter(adapter);
        binding.list.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public static Question[][] tests = new Question[][]{
            {
                new Question("Mrs. Hopkins is … school teacher.",new String[]{"a","an","the"},0),
                    new Question("Is that car … ?",new String[]{"you","your","yours"},2),
                    new Question("Who are … boys over there?",new String[]{"these","those","that"},1),
                    new Question("It is … day in Kerry's life.",new String[]{"the happiest","the happyest","the most happy"},0),
                    new Question("This summer the weather is … than last summer",new String[]{"more bad","badder","worse"},2),
                    new Question("Tom is taller … Kerry, because he is older.",new String[]{"than","then","as"},0),
                    new Question("You … speak loudly in the library.",new String[]{"not must","don't must","must not"},2),
                    new Question("… open the window?",new String[]{"can you","can you to","do you can"},0),
                    new Question("Who … pizza?",new String[]{"does like","like","likes"},2),
                    new Question("Why … so sad?",new String[]{"you are","do you","are you"},2),
                    new Question("… a kitchen on the ground floor.",new String[]{"it is","there is","this is"},1),
                    new Question("I usually play tennis … Monday.",new String[]{"at","on","in"},1),
                    new Question("We are going … the cinema tonight.",new String[]{"at","to","in"},1),
                    new Question("There are … apples in the garden.",new String[]{"a lot of","a little","much"},0),
                    new Question("There isn't … milk in the glass.",new String[]{"much","many","few"},0),
                    new Question("Lima … up early every morning.",new String[]{"gets","got","is getting"},0),
                    new Question("Tom … soccer now.",new String[]{"plays","played","is playing"},2),
                    new Question("Kerry … already … her teeth.",new String[]{"has…brushed","is…brushing","doesn't…brush"},0),
                    new Question("He … his leg last week.",new String[]{"break","breaked","broke"},2),
                    new Question("They … the work when it … dark.",new String[]{"finish…will get","will finish…will get","will finish…gets"},2),
            },
            {
                new Question("He … a student",new String[]{"is","am","were"},0),
                    new Question("… are you from?",new String[]{"when","were","where"},0),
                    new Question("… bag is it?",new String[]{"who","whom","whose"},2),
                    new Question("It is … big black sheep.",new String[]{"the","a","an"},1),
                    new Question("The old … were very angry.",new String[]{"woman","womans","women"},2),
                    new Question("There are a lot of red and yellow … on the trees",new String[]{"leave","leafs","leaves"},2),
                    new Question("There … a table, a chair and a sofa in the room.",new String[]{"were","are","is"},2),
                    new Question("There … a lot of plates on the table.",new String[]{"is","are","was"},1),
                    new Question("Pass me … salt, please.",new String[]{"any","some","many"},1),
                    new Question("Do you have … interesting coins?",new String[]{"any","some","much"},0),
                    new Question("They don't have … rare stamps.",new String[]{"some","the","any"},2),
                    new Question("Could you answer … questions?",new String[]{"any","a","some"},2),
                    new Question("How … money have you got with you?",new String[]{"much","many","often"},0),
                    new Question("How … sheep do you see in the picture?",new String[]{"much","many","old"},1),
                    new Question("Mary has got … nice dresses.",new String[]{"many","a lot of","much"},1),
                    new Question("There is too … butter in this cake.",new String[]{"many","much","some"},1),
                    new Question("Mike and his sister … got a lot of friends.",new String[]{"have","are","has"},0),
                    new Question("… you got a large family?",new String[]{"has","do","have"},2),
                    new Question("His aunt … a very old parrot.",new String[]{"have","like","has"},2),
                    new Question("Every child wants to … a pet.",new String[]{"has","have","likes"},1),
            }

    };
}