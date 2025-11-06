class Vertex{
public:
    int vertexId;
    bool offline = false;
    int powerGridId = -1;

    Vertex(){}
    Vertex(int id) : vertexId(id){}
};

using PowerGrid = priority_queue<int, vector<int>, greater<int>>;
using Graph = vector<vector<int>>;

class Solution {
    vector<Vertex> vertices = vector<Vertex>();

    void traverse(Vertex& u, int powerGridId, PowerGrid& powerGrid, Graph& graph){
        u.powerGridId = powerGridId;
        powerGrid.push(u.vertexId);
        for(int vId : graph[u.vertexId]){
            Vertex& v = vertices[vId];
            if(v.powerGridId == -1){
                traverse(v, powerGridId, powerGrid, graph);
            }
        }
    }
public:
    vector<int> processQueries(int c, vector<vector<int>>& connections, vector<vector<int>>& queries) {
        // Q. Power Grid Maintenance
        Graph graph(c + 1);
        vertices.resize(c + 1);

        for(int index = 1; index <= c; ++index){
            vertices[index] = Vertex(index);
        }

        for(auto& connection : connections){
            graph[connection.at(0)].push_back(connection.at(1));
            graph[connection.at(1)].push_back(connection.at(0));
        }

        vector<PowerGrid> powerGrids;
        for(int index = 1, powerGridId = 0; index <= c; ++index){
            auto& v = vertices[index];
            if(v.powerGridId == -1){
                PowerGrid powerGrid;
                traverse(v, powerGridId, powerGrid, graph);
                powerGrids.push_back(powerGrid);
                powerGridId++;
            }
        }

        vector<int> answer;
        for(auto& query : queries){
            int operation = query.at(0), vertex = query.at(1);
            if(operation == 1){
                if(!vertices[vertex].offline){
                    answer.push_back(vertex);
                }
                else{
                    auto& powerGrid = powerGrids[vertices[vertex].powerGridId];
                    while(!powerGrid.empty() && vertices[powerGrid.top()].offline){
                        powerGrid.pop();
                    }
                    answer.push_back(!powerGrid.empty() ? powerGrid.top() : -1);
                }
            }
            else if(operation == 2){
                vertices[vertex].offline = true;
            }
        }

        return answer;
    }
};